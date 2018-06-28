<!DOCTYPE html>
<%@page import="dw.GastosModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Venda</title>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <ol class="breadcrumb">
          <li><a href="/">Menu</a></li>
          <li class="active">Venda</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form>
              <div class="form-group">
                <input
                  name="codigo"
                  value="${param.codigo}"
                  type="text"
                  placeholder="C�digo"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="descricao"
                  value="${param.descricao}"
                  type="text"
                  placeholder="Descricao"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="valor"
                  value="${param.valor}"
                  type="number"
                  placeholder="Valor"
                  class="form-control">
              </div>
              <button name="op" value="incluir" class="btn btn-default">Incluir</button>
              <button name="op" value="salvar" class="btn btn-default">Salvar</button>
            </form>
          </div>
        </div>
        <table class="table table-bordered table-striped">
          <tr>
            <td>Codigo</td>
            <td>Descrição</td>
            <td>Valor</td>
            <td>#</td>
          </tr>
          <%
          List<GastosModel> gastos = (List<GastosModel>) request.getAttribute("gastos");
          for (GastosModel v:gastos) {
          %>
            <tr>
              <td><a href="gasto?codigo=<%=v.getCodigo()%>&descricao=<%=v.getDescricao()%>&valor=<%=v.getValor()%>"><%=v.getCodigo()%></a></td>
              <td><%=v.getDescricao()%></td>
              <td><%=v.getValor()%></td>
              <td><a href="gasto?op=excluir&codigo=<%=v.getCodigo()%>">Excluir</a></td>
            </tr>
          <%
          }
          %>
        </table>
      </div>
    </div>
  </div>
</body>
</html>