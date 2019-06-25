package com.bio.demo.Service;


import com.bio.demo.DataClass.ResponseObject;
import com.bio.demo.Utilies.StatusCode;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApiResponseService {

    public ApiResponseService() {
    }

    public ResponseObject sendCreateResponse(String entity, Object object){
        return apiResponse(entity, object, StatusCode.SUCCESS,"Created Successfully", "Create");
    }

    public ResponseObject sendUpdateResponse(String entity,Object object){
        return apiResponse(entity,object, StatusCode.SUCCESS,"Updated Successfully", "Update" );
    }

    public ResponseObject sendDeleteResponse(String entity,Object object){
        return apiResponse(entity, object, StatusCode.SUCCESS,"Deleted Successfully", "Delete" );
    }

    public ResponseObject sendReadResponse(String entity,Object object){
        return apiResponse(entity, object, StatusCode.SUCCESS,"Fetched Successfully", "Fetch" );
    }

    public ResponseObject sendListResponse(String entity, Object object){
        return apiResponse(entity, object, StatusCode.SUCCESS,"List Fetched Successfully", "List" );
    }

    private ResponseObject apiResponse(String entity, Object object, StatusCode action, String msg, String actionName) {
        return new ResponseObject(action.value(), entity + " "+ msg, Collections.emptyList(), object, entity, action.toString());
    }
}
