package com.rost.study.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import java.util.function.Supplier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rost.study.servlet.logic.Cart;

@WebServlet(name = "first-servlet", urlPatterns = "/firstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Writer writer = response.getWriter();
        writer.append("Hello, ").append(name).append(" ").append(surname);*/

        HttpSession session = request.getSession();

        /*Supplier<Integer> sessionCountIncr = () -> {
            int count = Optional.ofNullable((Integer) session.getAttribute("count")).orElse(0);
            session.setAttribute("count", ++count);
            return count;
        };*/


        Supplier<Cart> cartSupplier = () -> {
            Cart result = Optional.ofNullable((Cart) session.getAttribute("cart"))
                    .orElse(new Cart());

            String name = request.getParameter("name");
            int quantity = Integer.parseInt(
                    Optional.ofNullable(request.getParameter("quantity")).orElse("0")
            );

            result.setName(Optional.ofNullable(result.getName()).orElse(name));
            result.setQuantity(result.getQuantity() == 0 ? quantity : result.getQuantity());

            return result;
        };


        session.setAttribute("cart", cartSupplier.get());
        request.getRequestDispatcher("/firstJsp").forward(request, response);
    }
}
