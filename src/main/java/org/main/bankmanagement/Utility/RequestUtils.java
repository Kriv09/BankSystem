package org.main.bankmanagement.Utility;

import org.main.bankmanagement.DTO.Requests.Request;
import org.main.bankmanagement.DTO.Requests.RequestState;

public class RequestUtils {
    public static <T extends Request> RequestState checkRequestState(T request) {
        return request == null ? RequestState.EMPTY : RequestState.FULL;
    }
}

