# Android-Multiplayer-Tutorial
GRPC - Protocol Buffers - Multiplayer Architecture

Why GRPC:-

*Web infrastructure is already built on top of http  
*Bi-directional streaming is easy  
*Supports types and Validations  
*Faster  

Android app part:

1. Create proto files – actions, data streams, models, actual service
2. Generate the required Java files using Gradle plugin
3. Get a stub from dagger using @Inject
4. Call required method from stub asynchronously
5. Handle response

Server part:

1. Create proto files – actions, data streams, models, actual service
2. Generate the required Java files using Gradle plugin
3. Extend ActionServiceGrpc.ActionServiceImplBase interface
4. Implement required methods
5. Add interceptor (optional)
6. Add server.crt, server.key (optional)
7. Create MyServer.java and start server -> Woohoo!
