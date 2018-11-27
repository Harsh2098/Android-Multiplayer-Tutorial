package com.hmproductions.multiplayertutorial.services;

import com.hmproductions.multiplayertutorial.TutorialActionServiceGrpc;
import com.hmproductions.multiplayertutorial.actions.GetScore.GetScoreResponse;
import com.hmproductions.multiplayertutorial.actions.GetScore.GetScoreRequest;
import com.hmproductions.multiplayertutorial.actions.GetScore.GetScoreResponse.StatusCode;
import io.grpc.stub.StreamObserver;

import static com.hmproductions.multiplayertutorial.utils.Constants.MAX_PLAYERS;

public class TutorialActionServiceImpl extends TutorialActionServiceGrpc.TutorialActionServiceImplBase {

    @Override
    public void getScore(GetScoreRequest request, StreamObserver<GetScoreResponse> responseObserver) {

        int newId = request.getName().charAt(0) % MAX_PLAYERS;

        System.out.println("Action service called - getScore()");

        responseObserver.onNext(GetScoreResponse.newBuilder().setMessage("Hello "+ request.getName() +"! Your new ID is " + newId)
                .setStatusCode(StatusCode.OK).build());
        responseObserver.onCompleted();
    }
}
