package mrs.domain.service.room;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.repository.room.MeetingRoomRepository;
import mrs.domain.repository.room.ReservableRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    ReservableRoomRepository reservableRoomRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    public List<ReservableRoom> findReservableRooms(LocalDate date) {
        return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
    }

    public MeetingRoom findMeetingRoom(Integer roomId) {
        return meetingRoomRepository.findById(roomId).orElse(null);
    }

    public List<MeetingRoom> findAllMeetingRoom() {
        return meetingRoomRepository.findAll();
    }

    public MeetingRoom register(MeetingRoom room) {
        meetingRoomRepository.save(room);
        return room;
    }

    public void registerReservableRooms(Integer roomId, LocalDate startDate, LocalDate endDate) {
        LocalDate date = startDate;
        MeetingRoom meetingRoom = meetingRoomRepository.getOne(roomId);
        while (!date.isAfter(endDate)) {
            ReservableRoomId reservableRoomId = new ReservableRoomId(roomId, date);
            ReservableRoom room = new ReservableRoom(reservableRoomId);
            room.setMeetingRoom(meetingRoom);
            reservableRoomRepository.save(room);
            date = date.plusDays(1);
        }
    }

}
