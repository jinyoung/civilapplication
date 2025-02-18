package civilapplication.infra;

import civilapplication.config.kafka.KafkaProcessor;
import civilapplication.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ResultDocumentRepository resultDocumentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ApplicationSubmissionFailed'"
    )
    public void wheneverApplicationSubmissionFailed_ApplicationSubmissionFailureNotificationPolicy(
        @Payload ApplicationSubmissionFailed applicationSubmissionFailed
    ) {
        ApplicationSubmissionFailed event = applicationSubmissionFailed;
        System.out.println(
            "\n\n##### listener ApplicationSubmissionFailureNotificationPolicy : " +
            applicationSubmissionFailed +
            "\n\n"
        );
        // Comments //
        //DB 저장 또는 네트워크 장애 발생 시, 신청서 제출은 실패하지만 사용자에게 '잠시 후 다시 시도해 주세요.' 메시지를 전송하고 오류를 로깅하여 재시도 및 문제 확인을 지원하기 위함입니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ApplicationSubmitted'"
    )
    public void wheneverApplicationSubmitted_IssueResultDocumentPolicy(
        @Payload ApplicationSubmitted applicationSubmitted
    ) {
        ApplicationSubmitted event = applicationSubmitted;
        System.out.println(
            "\n\n##### listener IssueResultDocumentPolicy : " +
            applicationSubmitted +
            "\n\n"
        );
        // Comments //
        //신청서 제출이 성공적으로 처리된 후, 결과 문서를 자동으로 발행하여 민원 신청 내역과 발급번호를 제공함으로써 사용자에게 신청 결과를 확인할 수 있게 지원하기 위함입니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ApplicationSubmitted'"
    )
    public void wheneverApplicationSubmitted_ApplicationSubmissionSuccessNotificationPolicy(
        @Payload ApplicationSubmitted applicationSubmitted
    ) {
        ApplicationSubmitted event = applicationSubmitted;
        System.out.println(
            "\n\n##### listener ApplicationSubmissionSuccessNotificationPolicy : " +
            applicationSubmitted +
            "\n\n"
        );
        // Comments //
        //민원 신청이 정상적으로 저장된 경우, generateApplicationNumber()에 의해 발급 번호가 생성되고 결과 문서가 발급된 후, 신청자 및 관련 부서에게 확인 알림을 전송하여 후속 업무 처리를 원활하게 하기 위함.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
