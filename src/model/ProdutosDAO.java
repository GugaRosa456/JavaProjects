package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class ProdutosDAO {
	private static final DateTimeFormatter INPUT_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void adicionarProduto(Produtos produto) {
		if (produto == null) {
			JOptionPane.showMessageDialog(null, "Produto inválido", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (isEmpty(produto.getNomeProduto())) {
			JOptionPane.showMessageDialog(null, "Nome do produto é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		LocalDate df = parseLocalDate(produto.getDataFabricacao());
		if (df == null) {
			JOptionPane.showMessageDialog(null, "Data de fabricação inválida. Use dd/MM/yyyy.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		LocalDate dv = null;
		if (!isEmpty(produto.getDataVencimento())) {
			dv = parseLocalDate(produto.getDataVencimento());
			if (dv == null) {
				JOptionPane.showMessageDialog(null, "Data de vencimento inválida. Use dd/MM/yyyy.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		String sql = "INSERT INTO Produtos (nomeProduto, dataFabricacao, dataVencimento, valor, quantidade, marca, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = BancoDeDados.conectar()) {
			if (conn == null) {
				JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			try (PreparedStatement ps = conn.prepareStatement(
					"SELECT COLUMN_NAME, DATA_TYPE, COLUMN_TYPE FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'Produtos' AND COLUMN_NAME IN ('dataFabricacao','dataVencimento')")) {
				try (ResultSet rs = ps.executeQuery()) {
					System.out.println("DEBUG: Produtos table column types:");
					while (rs.next()) {
						System.out.println("  " + rs.getString("COLUMN_NAME") + " -> DATA_TYPE="
								+ rs.getString("DATA_TYPE") + ", COLUMN_TYPE=" + rs.getString("COLUMN_TYPE"));
					}
				}
			} catch (SQLException e) {
				System.out.println("DEBUG: failed to read column metadata: " + e.getMessage());
			}

			System.out.println("DEBUG: values to insert -> nome='" + produto.getNomeProduto() + "', dataFabricacao='"
					+ produto.getDataFabricacao() + "', dataVencimento='" + produto.getDataVencimento() + "', valor="
					+ produto.getValor() + ", quantidade=" + produto.getQuantidade() + ", marca='" + produto.getMarca()
					+ "', estado='" + produto.getEstado() + "'");

			try {
				insertWithDateBinding(conn, sql, produto, df, dv);
				return;
			} catch (SQLException ex) {
				String msg = ex.getMessage() == null ? "" : ex.getMessage().toLowerCase();

				if (msg.contains("data truncated") || msg.contains("incorrect date value") || msg.contains("truncated")
						|| msg.contains("invalid date")) {
					try {
						alterColumnsToVarchar(conn);
						insertWithStringBinding(conn, sql, produto);
						return;
					} catch (SQLException ex2) {
						ex2.printStackTrace();
						JOptionPane.showMessageDialog(null,
								"Erro ao inserir produto após tentativa de correção de esquema: " + ex2.getMessage(),
								"Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao inserir produto: " + ex.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir produto: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void insertWithDateBinding(Connection conn, String sql, Produtos produto, LocalDate df, LocalDate dv)
			throws SQLException {
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, produto.getNomeProduto());
			pstm.setDate(2, Date.valueOf(df));
			if (dv != null)
				pstm.setDate(3, Date.valueOf(dv));
			else
				pstm.setNull(3, java.sql.Types.DATE);
			pstm.setDouble(4, produto.getValor());
			pstm.setInt(5, produto.getQuantidade());
			pstm.setString(6, produto.getMarca() == null ? "" : produto.getMarca());
			pstm.setString(7, produto.getEstado() == null ? "" : produto.getEstado());
			pstm.executeUpdate();
		}
	}

	private void insertWithStringBinding(Connection conn, String sql, Produtos produto) throws SQLException {
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, produto.getNomeProduto());
			pstm.setString(2, produto.getDataFabricacao() == null ? "" : produto.getDataFabricacao());
			pstm.setString(3, produto.getDataVencimento() == null ? "" : produto.getDataVencimento());
			pstm.setDouble(4, produto.getValor());
			pstm.setInt(5, produto.getQuantidade());
			pstm.setString(6, produto.getMarca() == null ? "" : produto.getMarca());
			pstm.setString(7, produto.getEstado() == null ? "" : produto.getEstado());
			pstm.executeUpdate();
		}
	}

	private void alterColumnsToVarchar(Connection conn) throws SQLException {
		String[] cols = { "dataFabricacao", "dataVencimento" };
		for (String col : cols) {
			String alter = "ALTER TABLE Produtos MODIFY " + col + " VARCHAR(20) NULL";
			try (Statement st = conn.createStatement()) {
				st.execute(alter);
				System.out.println("DEBUG: altered column " + col + " to VARCHAR(20)");
			}
		}
	}

	private LocalDate parseLocalDate(String text) {
		if (isEmpty(text))
			return null;
		try {
			return LocalDate.parse(text, INPUT_DATE);
		} catch (DateTimeParseException ex) {
			return null;
		}
	}

	public List<Produtos> listarProdutos() {
		List<Produtos> produtos = new ArrayList<>();
		String sql = "SELECT id, nomeProduto, dataFabricacao, dataVencimento, valor, quantidade, marca, estado FROM Produtos";
		try (Connection conn = BancoDeDados.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Produtos p = new Produtos(rs.getString("nomeProduto"), rs.getString("dataFabricacao"),
						rs.getString("dataVencimento"), rs.getDouble("valor"), rs.getInt("quantidade"),
						rs.getString("marca"), rs.getString("estado"), rs.getInt("id"));
				produtos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		return produtos;
	}

	public Produtos buscarPorNome(String nome) {
		if (isEmpty(nome))
			return null;
		String sql = "SELECT id, nomeProduto, dataFabricacao, dataVencimento, valor, quantidade, marca, estado FROM Produtos WHERE nomeProduto = ? LIMIT 1";
		try (Connection conn = BancoDeDados.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nome);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Produtos(rs.getString("nomeProduto"), rs.getString("dataFabricacao"),
							rs.getString("dataVencimento"), rs.getDouble("valor"), rs.getInt("quantidade"),
							rs.getString("marca"), rs.getString("estado"), rs.getInt("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void atualizarProduto(Produtos produto) {
		if (produto == null || produto.getId() <= 0)
			return;
		String sql = "UPDATE Produtos SET nomeProduto=?, dataFabricacao=?, dataVencimento=?, valor=?, quantidade=?, marca=?, estado=? WHERE id=?";
		try (Connection conn = BancoDeDados.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getDataFabricacao());
			stmt.setString(3, produto.getDataVencimento());
			stmt.setDouble(4, produto.getValor());
			stmt.setInt(5, produto.getQuantidade());
			stmt.setString(6, produto.getMarca() == null ? "" : produto.getMarca());
			stmt.setString(7, produto.getEstado() == null ? "" : produto.getEstado());
			stmt.setInt(8, produto.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void diminuirQuantidade(String nomeProduto) {
		if (isEmpty(nomeProduto))
			return;
		String sql = "UPDATE Produtos SET quantidade = quantidade - 1 WHERE nomeProduto = ? AND quantidade > 0";
		try (Connection conn = BancoDeDados.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nomeProduto);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao atualizar quantidade: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean isEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}
}