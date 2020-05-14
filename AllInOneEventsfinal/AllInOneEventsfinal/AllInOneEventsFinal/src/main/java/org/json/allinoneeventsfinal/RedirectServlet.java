/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json.allinoneeventsfinal;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.allinoneeventsfinal.TicketMaster;
import org.json.allinoneeventsfinal.Event;

//
///**
// *
// * @author rhiya
// */
@WebServlet("/ticketmasterevent.html")
public class RedirectServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RedirectServlet.class.getName());

    private TicketMaster el;

    @Inject
    public RedirectServlet(TicketMaster el) {
        this.el = el;
    }

    public void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        List<Event> eventsList = el.findAllEvents();
        request.setAttribute("eventsList", eventsList);
        LOG.log(Level.INFO, "  " + request.getUserPrincipal().getName());
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/ticketmasterevents.jsp");
        requestDispatcher.forward(request, response);

    }
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RedirectServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RedirectServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//
//    public void redirect() {
//        TicketMaster ticketMaster = new TicketMaster();
//
//        JsonObject object = ticketMaster.getJsonObject("events", "&city=" + "london");
//
//        List<Event> eventsList = ticketMaster.getEventsList(object);
//        for (int i = 0; i < eventsList.size(); i++) {
//            eventsList.get(i).getName();
//            eventsList.get(i).getId();
//            eventsList.get(i).getUrl();
//            eventsList.get(i).getLocalTime();
//            eventsList.get(i).getLocalDate();
//            eventsList.get(i).getCode();
//            eventsList.get(i).getGenreName();
//            eventsList.get(i).getNote();
//            eventsList.get(i).getType();
//            eventsList.get(i).getMin();
//            eventsList.get(i).getMax();
//            eventsList.get(i).getVenName();
//            eventsList.get(i).getVenPostcode();
//            eventsList.get(i).getCity();
//
//        }
//    }

//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
}
