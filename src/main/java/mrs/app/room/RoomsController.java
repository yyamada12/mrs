package mrs.app.room;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("rooms")
public class RoomsController {
    @Autowired
    RoomService roomService;

    @RequestMapping(path = "list", method = RequestMethod.GET)
    String listRooms(Model model) {
        LocalDate today = LocalDate.now();
        List<ReservableRoom> rooms = roomService.findReservableRooms(today);
        model.addAttribute("date", today);
        model.addAttribute("rooms", rooms);
        return "room/listRooms";
    }

    @RequestMapping(path = "list/{date}", method = RequestMethod.GET)
    String listRooms(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
        List<ReservableRoom> rooms = roomService.findReservableRooms(date);
        model.addAttribute("rooms", rooms);
        return "room/listRooms";
    }

    @RequestMapping(path = "meeting/list", method = RequestMethod.GET)
    String listMeetingRooms(Model model) {
        List<MeetingRoom> rooms = roomService.findAllMeetingRoom();
        model.addAttribute("rooms", rooms);
        return "room/listMeetingRooms";
    }

    @RequestMapping(path = "meeting/register", method = RequestMethod.GET)
    String meetingRoomForm(Model model) {
        model.addAttribute(new MeetingRoomForm());
        model.addAttribute("date", LocalDate.now());
        return "room/meetingRoomForm";
    }

    @RequestMapping(path = "meeting/register", method = RequestMethod.POST)
    String registerMeetingRoom(@Validated MeetingRoomForm form,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return meetingRoomForm(model);
        }
        MeetingRoom room = new MeetingRoom();
        room.setRoomName(form.getRoomName());
        roomService.register(room);
        return "redirect:/rooms/meeting/list";
    }
}
