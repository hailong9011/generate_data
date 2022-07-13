package atwom.work.receive_ms_kafka.config.batch;

import org.springframework.batch.item.ItemProcessor;

import atwom.work.receive_ms_kafka.connect_db.mariadb.entity.User;

public class UserProcessor implements ItemProcessor<User, User>{

	@Override
	public User process(User user) throws Exception {
		return user;
	}
	
}
