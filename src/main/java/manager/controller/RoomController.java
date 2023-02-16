package manager.controller;

import manager.model.Room;
import manager.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
@RequestMapping("/room")
public class RoomController{
    RoomService roomService;

    public RoomController() {
        roomService =new RoomService();
    }

    @GetMapping("/display")
    public String listRoom(HttpServletRequest request, Model model){
        model.addAttribute("room", roomService.findAll());
        return "/room/display";
    }
    @GetMapping("/create")
    public String showCreate (){
        return "/room/create";
    }
    @PostMapping("/create")
    public String create(HttpServletRequest request,Model model){
        int id = Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
            roomService.save(new Room(id,name));
        model.addAttribute("room", roomService.findAll());
        return "/room/display";
    }
}
