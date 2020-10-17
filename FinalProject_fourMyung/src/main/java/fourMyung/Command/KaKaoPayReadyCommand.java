package fourMyung.Command;

import java.util.Date;

import lombok.Data;

@Data
public class KaKaoPayReadyCommand {
	private String tid, next_redirect_pc_url;
	private Date created_at;
}
