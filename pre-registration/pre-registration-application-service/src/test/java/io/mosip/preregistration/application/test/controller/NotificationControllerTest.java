//
//package io.mosip.preregistration.application.test.controller;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.nio.charset.Charset;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.security.test.context.support.WithUserDetails;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
////import io.mosip.preregistration.booking.service.BookingServiceIntf;
//import io.mosip.preregistration.core.common.dto.MainResponseDTO;
//import io.mosip.preregistration.core.common.dto.NotificationDTO;
//import io.mosip.preregistration.core.util.RequestValidator;
//import io.mosip.preregistration.core.util.ValidationUtil;
//import io.mosip.preregistration.application.service.DemographicServiceIntf;
//import io.mosip.preregistration.application.service.DocumentServiceIntf;
//import io.mosip.preregistration.application.dto.NotificationResponseDTO;
//import io.mosip.preregistration.application.service.NotificationService;
//import io.mosip.preregistration.application.service.util.NotificationServiceUtil;
//import io.mosip.preregistration.application.test.PreRegistrationApplicationTest;
//
///**
// * @author Sanober Noor
// * @since 1.0.0
// */
//@SpringBootTest(classes = { PreRegistrationApplicationTest.class })
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//public class NotificationControllerTest {
//
//	/**
//	 * Autowired reference for {@link #MockMvc}
//	 */
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper mapper;
//
//	@Mock
//	private RequestValidator requestValidator;
//
//	@MockBean
//	private ValidationUtil validationUtil;
//
//	@Mock
//	private DemographicServiceIntf preRegistrationService;
//
//	/**
//	 * Creating Mock Bean for DocumentUploadService
//	 */
//	@Mock
//	private DocumentServiceIntf demoservice;
//
//	/**
//	 * /** Creating Mock Bean for NotificationService
//	 */
//	@MockBean
//	private NotificationService service;
//
//	@MockBean
//	private NotificationServiceUtil serviceUtil;
//
//	private NotificationDTO notificationDTO;
//
//	MainResponseDTO<NotificationResponseDTO> responseDTO = new MainResponseDTO<>();
//
//	MainResponseDTO<Map<String, String>> configRes = new MainResponseDTO<>();
//	NotificationResponseDTO respDTO = new NotificationResponseDTO();
//
//	@Before
//	public void setUp() {
//		notificationDTO = new NotificationDTO();
//		notificationDTO.setName("sanober Noor");
//		notificationDTO.setPreRegistrationId("1234567890");
//		notificationDTO.setMobNum("1234567890");
//		notificationDTO.setEmailID("sanober,noor2@mindtree.com");
//		notificationDTO.setAppointmentDate("2019-01-22");
//		notificationDTO.setAppointmentTime("22:57");
//		respDTO.setMessage("Email and sms request successfully submitted");
//		responseDTO.setResponse(respDTO);
//		responseDTO.setResponsetime(validationUtil.getCurrentResponseTime());
//
//	}
//
//	/**
//	 * This test method is for success sendNotification method
//	 * 
//	 * @throws Exception
//	 */
//	//
//	@WithUserDetails("INDIVIDUAL")
//	@Test
//	public void sendNotificationTest() throws Exception {
//		String stringjson = mapper.writeValueAsString(notificationDTO);
//		String langCode = "eng";
//		Mockito.when(service.sendNotification(stringjson, "eng", null)).thenReturn(responseDTO);
//
//		mockMvc.perform(MockMvcRequestBuilders.multipart("/notify")
//				.file(new MockMultipartFile("NotificationRequestDTO", stringjson, "application/json",
//						stringjson.getBytes(Charset.forName("UTF-8"))))
//				.file(new MockMultipartFile("langCode", langCode, "application/json",
//						langCode.getBytes(Charset.forName("UTF-8")))))
//				.andExpect(status().isOk());
//
//	}
//}
