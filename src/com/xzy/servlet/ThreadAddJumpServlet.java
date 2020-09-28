package com.xzy.servlet;

import com.xzy.entity.Employee;
import com.xzy.entity.Industry;
import com.xzy.entity.Levels;
import com.xzy.entity.Sources;
import com.xzy.service.EmployeeService;
import com.xzy.service.IndustryService;
import com.xzy.service.LevelsService;
import com.xzy.service.SourcesService;
import com.xzy.service.impl.EmployeeServiceImpl;
import com.xzy.service.impl.IndustryServiceImpl;
import com.xzy.service.impl.LevelsServiceImpl;
import com.xzy.service.impl.SourcesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ThreadAddJumpServlet")
public class ThreadAddJumpServlet extends HttpServlet {

    private final EmployeeService EMPLOYEESERVICE = new EmployeeServiceImpl();
    private final SourcesService SOURCESSERVICE = new SourcesServiceImpl();
    private final IndustryService INDUSTRYSERVICE = new IndustryServiceImpl();
    private final LevelsService LEVELSSERVICE = new LevelsServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = EMPLOYEESERVICE.getEmployeeList();
        List<Sources> sourcesList = SOURCESSERVICE.getSourcesList();
        List<Industry> industryList = INDUSTRYSERVICE.getIndustryList();
        List<Levels> levelsList = LEVELSSERVICE.getLevelsList();
        request.setAttribute("employees", employeeList);
        request.setAttribute("sources", sourcesList);
        request.setAttribute("industries", industryList);
        request.setAttribute("levels", levelsList);
        request.getRequestDispatcher("/thread_add.jsp").forward(request, response);
    }
}
