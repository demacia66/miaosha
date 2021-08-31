package com.ycy.miaosha.exception;

import com.ycy.miaosha.result.CodeMsg;
import lombok.Data;



/**
 * @author yuanchenyu
 */
@Data

public class GlobalException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm = cm;
    }

}
