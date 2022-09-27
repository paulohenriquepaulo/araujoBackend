package app.exeception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class AraujoExeception extends RuntimeException{
	
	private final Map<String, String> errors;

    private HttpStatus status;

    public AraujoExeception() {
        this.errors = new HashMap<>();
    }

    public AraujoExeception(String descricao, HttpStatus status) {
        this();
        this.status = status;
        add("status", String.valueOf(status.value()));
        add("mensagem", descricao);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void add(String erro, String descricao) {
        this.errors.put(erro, descricao);
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
