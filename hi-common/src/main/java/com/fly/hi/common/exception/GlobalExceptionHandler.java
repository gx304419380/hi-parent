package com.fly.hi.common.exception;

import com.fly.hi.common.dto.ResponseDto;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 全局异常拦截器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) throws IllegalArgumentException {
//                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            }
//        });
//        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) throws IllegalArgumentException {
//                setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//            }
//        });
//        binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) throws IllegalArgumentException {
//                setValue(LocalTime.parse(text, DateTimeFormatter.ofPattern("HH:mm:ss")));
//            }
//        });
//    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDto defaultExceptionHandler(HttpServletRequest req, Exception e){
        e.printStackTrace();
        return new ResponseDto(500, "未知错误！");
    }

    @ExceptionHandler(BaseRuntimeException.class)
    @ResponseBody
    public ResponseDto BaseRuntimeExceptionHandler(HttpServletRequest req, BaseRuntimeException e){
        return new ResponseDto(e.getCode(), e.getMessage());
    }

}
