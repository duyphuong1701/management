package app.chatbot.service.management.service.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ChatbotMLService {

    private static final String POST_TRAIN_V2 = "/train2";
    private static final String POST_FIND_PARAMETER_v2 = "/find-parameter-sol2";
    private static final String POST_TRAIN_MULTI_V2 ="/train-multi-sol2";

    @Value("${chatbot-ml.host}")
    private String chatbotHost;

    @Autowired
    private RestTemplate restTemplate;

    public void trainV2(Float c,Integer randomState,Boolean shuffle,Float test_size) {
        String url = chatbotHost + POST_TRAIN_V2;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("c", String.valueOf(c));
        map.add("random_state", String.valueOf(randomState));
        if (shuffle == true){
            map.add("shuffle","True");
        }
        map.add("shuffle","False");
        map.add("test_size",test_size.toString());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        log.info(String.format("Start training V2 with c = %s, random_state = %s, shuffle = %s, test_size =  %s",c,randomState,shuffle,test_size));
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        log.info(String.valueOf(response.getHeaders().values()));
    }
    public void findParameterV2(Integer randomState){

        String url = chatbotHost + POST_FIND_PARAMETER_v2;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("random_state", String.valueOf(randomState));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        log.info(String.format("Start find V2 with random_state = %s",randomState));
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        log.info(String.valueOf(response.getHeaders().values()));
    }

    public void trainMultiV2(Float c,Integer times){
        String url = chatbotHost + POST_TRAIN_MULTI_V2;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("c", String.valueOf(c));
        map.add("times", String.valueOf(times));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        log.info(String.format("Start find V2 with random_state = %s times = %s",c,times));
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        log.info(String.valueOf(response.getHeaders().values()));
    }
}
