package dw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class  GastosModel {
  private String codigo;
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  private String descricao;
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  private Float valor;
  public Float getvalor() {
    return valor;
  }
  public void setvalor(Float valor) {
    this.valor = valor;
  }

  private static Connection obterConexao() throws SQLException {
    //Estabelecer uma conexão com o banco de dados.
    String url = "jdbc:derby://localhost:1527/gastodb;create=true";
    String user = "app";
    String password = "app";
    return DriverManager.getConnection(url, user, password);
  }

  public void incluir() throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "insert into gastos (codigo, descricao, valor) values (?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, codigo);
    pstmt.setString(2, descricao);
    pstmt.setFloat(3, valor);
    pstmt.execute();
  }

  public void salvar() throws SQLException {
    Connection conn = obterConexao();

    //Obter sentença SQL.
    String sql = "update gastos set descricao = ?, valor = ? where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, descricao);
    pstmt.setFloat(2, valor);
    pstmt.setString(3, codigo);
    pstmt.execute();
  }

  public void excluir() throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "delete from gastos where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, codigo);
    pstmt.execute();
  }

  public static List<GastosModel> listar() throws SQLException {
    Connection conn = obterConexao();
    
    Statement stmt = conn.createStatement();
    String sql = "select codigo, descricao, valor from gastos order by codigo";
    ResultSet rs = stmt.executeQuery(sql);
  
    List<GastosModel> ListaDeGastos = new ArrayList<GastosModel>();
    while (rs.next()) {
      // Cria um gasto para o registro.
      GastosModel gastos = new GastosModel();
      gastos.setCodigo(rs.getString("codigo"));
      gastos.setDescricao(rs.getString("descricao"));
      gastos.setvalor(rs.getFloat("valor"));
      // Adiciona o gasto na lista de gastos.
      ListaDeGastos.add(gastos);
    }
    return ListaDeGastos;
  }
}
