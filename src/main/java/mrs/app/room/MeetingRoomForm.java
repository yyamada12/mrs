package mrs.app.room;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MeetingRoomForm implements Serializable {
    @NotNull(message = "必須です")
    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
