package com.bluespacetech.notifications.email;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.mail.SimpleMailMessageItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@EnableBatchProcessing
public class EmailBatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JavaMailSender javaMailSender;

	@Autowired
	public DataSource dataSource;

	private static String QUERY_FIND_CONTACTS = "SELECT FIRST_NAME, LAST_NAME, EMAIL, GROUP_ID, CONTACT_ID FROM CONTACTS "
			+ "C, CONTACT_GROUP CG WHERE CG.CONTACT_ID = C.ID ";

	@Bean
	@StepScope
	JdbcCursorItemReader<EmailContactGroupVO> databaseItemReader(DataSource dataSource,
			@Value("#{jobParameters[groupId]}") Long groupId, @Value("#{jobParameters[message]}") String message,
			@Value("#{jobParameters[subject]}") String subject) {
		final JdbcCursorItemReader<EmailContactGroupVO> databaseReader = new JdbcCursorItemReader<EmailContactGroupVO>();
		databaseReader.setDataSource(dataSource);
		final EmailContactGroupRowMapper emailContactGroupRowMapper = new EmailContactGroupRowMapper();
		emailContactGroupRowMapper.setMessage(message);
		emailContactGroupRowMapper.setSubject(subject);
		databaseReader.setRowMapper(emailContactGroupRowMapper);
		databaseReader.setSql(QUERY_FIND_CONTACTS);
		QUERY_FIND_CONTACTS = QUERY_FIND_CONTACTS + " AND CG.GROUP_ID = " + groupId;
		return databaseReader;
	}

	@Bean
	public ItemWriter<SimpleMailMessage> simpleEmailWriter(MailSender javaMailSender) {
		final SimpleMailMessageItemWriter writer = new SimpleMailMessageItemWriter();
		writer.setMailSender(javaMailSender);
		return writer;
	}

	@Bean
	@StepScope
	public EmailGroupContactItemProcessor processor(@Value("#{jobParameters[message]}") String message,
			@Value("#{jobParameters[subject]}") String subject) {
		return new EmailGroupContactItemProcessor();
	}


	@Bean(name = "groupEmailJob")
	public Job groupEmailJob() {
		return jobBuilderFactory.get("groupEmailJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<EmailContactGroupVO, SimpleMailMessage> chunk(10)
				.reader(databaseItemReader(dataSource, null, null, null))
				.processor(processor(null, null))
				.writer(simpleEmailWriter(javaMailSender)).build();
	}

}
