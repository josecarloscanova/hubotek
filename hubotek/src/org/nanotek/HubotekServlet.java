package org.nanotek;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HubotekServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
