package servicio;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tienda.on.ProductoON;

@WebServlet("/imagen/*")
public class ImgServlet extends HttpServlet {

	@Inject
	private ProductoON prodON;

	protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta)
			throws ServletException, IOException {

		System.out.println("metodo servlet");

		String idImg = solicitud.getParameter("id");
		System.out.println(idImg);

		if (idImg == null) {
			respuesta.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;

		}
		
		
		
//		System.out.println(prodON.getProductoImagen(idImg));

		respuesta.reset();
		respuesta.getOutputStream().write(prodON.getProductoImagen(idImg));

	}

}
