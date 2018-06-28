package dw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/gastos/controle")
public class GastoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String op = request.getParameter("op");
    op = (op == null ? "" : op);

    GastosModel gasto = new GastosModel();
    gasto.setCodigo(request.getParameter("codigo"));
    gasto.setDescricao(request.getParameter("descricao"));
    String valorStr = request.getParameter("valor");
    valorStr = (valorStr == null ? "0" : valorStr);
    gasto.setvalor(Float.parseFloat(valorStr));

    List<GastosModel> gastos = null;
    try {
      if (op.equals("incluir")) {
        gasto.incluir();
      } else if (op.equals("salvar")) {
        gasto.salvar();
      } else if (op.equals("excluir")) {
        gasto.excluir();
      }

      gastos = GastosModel.listar();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
    //Adiciona a variável na requisição para o JSP trabalhar.
    request.setAttribute("gastos", gastos);

    //Redireciona requisição para o JSP.
    request.
      getRequestDispatcher("/gastos-mvc/gastos-view.jsp").
      forward(request, response);
  }
}
