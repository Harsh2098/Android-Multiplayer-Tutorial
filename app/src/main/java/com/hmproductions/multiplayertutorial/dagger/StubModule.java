package com.hmproductions.multiplayertutorial.dagger;

import com.hmproductions.multiplayertutorial.TutorialActionServiceGrpc;
import com.hmproductions.multiplayertutorial.utils.Miscellaneous;
import dagger.Module;
import dagger.Provides;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;

@Module
public class StubModule {

    @Provides
    @TutorialApplicationScope
    TutorialActionServiceGrpc.TutorialActionServiceBlockingStub getTutorialBlockingStub(ManagedChannel channel) {
        TutorialActionServiceGrpc.TutorialActionServiceBlockingStub stub = TutorialActionServiceGrpc.newBlockingStub(channel);
        return MetadataUtils.attachHeaders(stub, getStubMetadata());
    }

    private Metadata getStubMetadata() {
        Metadata metadata = new Metadata();
        Metadata.Key<String> metadataKey = Metadata.Key.of("sessionid", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(metadataKey, Miscellaneous.sessionId);
        return metadata;
    }
}
