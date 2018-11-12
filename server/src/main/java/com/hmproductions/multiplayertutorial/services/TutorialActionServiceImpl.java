package com.hmproductions.multiplayertutorial.services;

import com.hmproductions.multiplayertutorial.TutorialActionServiceGrpc;
import com.hmproductions.multiplayertutorial.actions.GetScore.GetScoreResponse;
import com.hmproductions.multiplayertutorial.actions.GetScore.GetScoreRequest;
import com.hmproductions.multiplayertutorial.actions.GetScore.GetScoreResponse.StatusCode;
import io.grpc.stub.StreamObserver;

public class TutorialActionServiceImpl extends TutorialActionServiceGrpc.TutorialActionServiceImplBase {

    @Override
    public void getScore(GetScoreRequest request, StreamObserver<GetScoreResponse> responseObserver) {

        responseObserver.onNext(GetScoreResponse.newBuilder().setMessage("Hello player " + request.getId())
                .setStatusCode(StatusCode.OK).build());
        responseObserver.onCompleted();
    }
}
