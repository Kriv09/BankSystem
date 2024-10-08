package org.main.bankmanagement.Utility;

import org.main.bankmanagement.DTO.Requests.AddUserRequest;
import org.main.bankmanagement.DTO.Requests.RequestState;

public class RequestUtils {
    public static RequestState checkRequestState(AddUserRequest request) {
        return request == null ? RequestState.EMPTY : RequestState.FULL;
    }

}
