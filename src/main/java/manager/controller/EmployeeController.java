package manager.controller;

import manager.model.Employee;
import manager.model.Room;
import manager.service.EmployeeService;
import manager.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    static RoomService roomService=new RoomService();
    static EmployeeService employeeService=new EmployeeService(roomService);

    public EmployeeController() {
    }

    @GetMapping("/display")
    public String listEmployee(HttpServletRequest request, Model model) {
        List<Employee> list = employeeService.findAll();
        int totalPages = (int) Math.ceil(list.size() / 3);
        String currentPageStr = request.getParameter("page");
        int currentPage = (currentPageStr != null) ? Integer.parseInt(currentPageStr) : 1;
        if (currentPage > totalPages + 1) {
            currentPage = 1;
        } else {
            if (currentPage < 1) {
                currentPage = totalPages + 1;
            }
        }
        int startIndex = (currentPage - 1) * 3;
        int endIndex = Math.min(startIndex + 3, list.size());
        List<Employee> currentPageProducts = list.subList(startIndex, endIndex);
        request.setAttribute("list", currentPageProducts);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        model.addAttribute("room", roomService.findAll());
        return "/employee/display";
    }

    @GetMapping("/create")
    public String showCreate(HttpServletRequest request, Model model) {
        model.addAttribute("room", roomService.findAll());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest request, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int room_id= Integer.parseInt(request.getParameter("room"));
        employeeService.save(new Employee(id, name, age, address,roomService.findById(room_id)));
        model.addAttribute("list", employeeService.findAll());
        return "/employee/display";
    }
    @GetMapping("/edit")
    public String showEdit(HttpServletRequest request, Model model,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id =Integer.parseInt(request.getParameter("id"));
        Employee employee = null;
        for (Employee e :
                employeeService.findAll()) {
            if (e.getId()== id){
                employee=e;
                break;
            }
        }
        model.addAttribute("room", roomService.findAll());
        model.addAttribute("employee",employee);
        return "/employee/edit";
    }
    @PostMapping("/edit")
    public String edit(HttpServletRequest request, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int room_id= Integer.parseInt(request.getParameter("room"));
        Employee employee = employeeService.findById(id);
        employeeService.update(employeeService.findAll().indexOf(employee), new Employee(id, name, age, address,roomService.findById(room_id)));
        model.addAttribute("list", employeeService.findAll());
        return "/employee/display";
    }

    @GetMapping("/delete")
    public String showDelete(HttpServletRequest request, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Employee employee = null;
        for (Employee e :
                employeeService.findAll()) {
            if (e.getId() == id) {
                employee = e;
                break;
            }
        }
        model.addAttribute("employee", employee);
        return "/employee/delete";
    }
    @PostMapping("/delete")
    public String delete(HttpServletRequest request, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(employeeService.findById(id));
        model.addAttribute("list", employeeService.findAll());
        return "/employee/display";
    }
    @PostMapping("/search")
    public String search(HttpServletRequest request, Model model){
        String search=request.getParameter("search");
        model.addAttribute("list", employeeService.findByName(search));
        return "/employee/display";
    }
}
