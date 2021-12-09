import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {
		MemberService msv = new MemberServiceImpl();
		msv.register(new MemberVO("test", "password", "nkname"));
		msv.getList();
	}
}
