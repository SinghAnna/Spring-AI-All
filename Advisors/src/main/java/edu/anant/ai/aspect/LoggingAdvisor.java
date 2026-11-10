
@Slf4j
@Component
public class LoggingAdvisor implements CallAdvisor  {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        logRequest(chatClientRequest);
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
        logResponse(chatClientResponse);
        return chatClientResponse;
    }

    private void logRequest(ChatClientRequest chatClientRequest) {
        log.info("Request {}", chatClientRequest);
    }

    private void logResponse(ChatClientResponse chatClientResponse) {
        log.info("Response {}", chatClientResponse);
    }

}