/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Core.Entities.Json;
import Service.Entities.Habitacion;
import Service.Logic.HabitacionService;

/**
 *
 * @author keiner5212
 */
@WebServlet(name = "HabitacionSrv", urlPatterns = { "/HabitacionSrv" })
public class HabitacionSrv extends HttpServlet {

        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request  servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException      if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

                JsonObject eljeison = Json.GetJsonFromRequestBody(request);

                JsonElement token = eljeison.get("token");
                if (token == null)
                return;

                List<Habitacion> habitaciones = HabitacionService.getHabitaciones(token.getAsString());

                request.setAttribute("habitaciones", habitaciones);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request  servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException      if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

                JsonObject eljeison = Json.GetJsonFromRequestBody(request);

                JsonArray services = eljeison.get("services_array").getAsJsonArray();
                String serviceString = "";
                if (services != null) {
                for (JsonElement jsonElement : services) {
                serviceString += jsonElement.getAsString() + ";";
                }
                } else {
                return;
                }

                JsonElement titulo = eljeison.get("titulo");
                if (titulo == null)
                return;
                JsonElement token = eljeison.get("token");
                if (token == null)
                return;
                JsonElement pais = eljeison.get("pais");
                if (pais == null)
                return;
                JsonElement ciudad = eljeison.get("ciudad");
                if (ciudad == null)
                return;
                JsonElement descripcion = eljeison.get("descripcion");
                if (descripcion == null)
                return;
                JsonElement imageUrl = eljeison.get("imageUrl");
                if (imageUrl == null)
                return;

                HabitacionService.saveHabitacion(Habitacion.builder()
                .titulo(titulo.getAsString())
                .pais(pais.getAsString())
                .ciudad(ciudad.getAsString())
                .descripcion(descripcion.getAsString())
                .servicios(serviceString)
                .imagen(imageUrl.getAsString())
                .build(),token.getAsString());

                request.setAttribute("mensaje", "Habitacion registrada");

        }

}
