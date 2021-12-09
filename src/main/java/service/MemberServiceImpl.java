package service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao = new MemberDAOImpl();

	@Override
	public int register(MemberVO mvo) {

		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> getList() {

		return mdao.selectList();
	}

	@Override
	public MemberVO getOne(String email) {

		return mdao.selectOne(email);
	}

	@Override
	public int modify(MemberVO mvo) {

		return mdao.update(mvo);
	}

	@Override
	public int remove(String email) {

		return mdao.delete(email);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		MemberVO loggedIn = mdao.selectOne(mvo);
		if(loggedIn != null) mdao.update(mvo.getEmail());
		loggedIn.setLastLogin(LocalDateTime.now().toString());
		return loggedIn;
	}
}
