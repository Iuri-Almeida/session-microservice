package com.letscode.agrocinetickets.Sessionmicroservice.util.mapper;

import com.letscode.agrocinetickets.Sessionmicroservice.model.Session;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionRequest;
import com.letscode.agrocinetickets.Sessionmicroservice.model.dto.SessionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    Session requestToModel(SessionRequest sessionRequest);

    SessionResponse modelToResponse(Session session);

}
