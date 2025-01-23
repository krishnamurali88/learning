package org.car.park;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: CarPark.proto")
public final class CarParkServiceGrpc {

  private CarParkServiceGrpc() {}

  public static final String SERVICE_NAME = "org.car.park.CarParkService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.car.park.ParkRequest,
      org.car.park.ParkResponse> METHOD_PARK_VEHICLE =
      io.grpc.MethodDescriptor.<org.car.park.ParkRequest, org.car.park.ParkResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "org.car.park.CarParkService", "parkVehicle"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.car.park.ParkRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.car.park.ParkResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.car.park.ParkRequest,
      org.car.park.ParkResponseManyTimes> METHOD_PARK_VEHICLE_MANY_TIMES =
      io.grpc.MethodDescriptor.<org.car.park.ParkRequest, org.car.park.ParkResponseManyTimes>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "org.car.park.CarParkService", "parkVehicleManyTimes"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.car.park.ParkRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.car.park.ParkResponseManyTimes.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarParkServiceStub newStub(io.grpc.Channel channel) {
    return new CarParkServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarParkServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CarParkServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarParkServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CarParkServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CarParkServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unery request 
     * </pre>
     */
    public void parkVehicle(org.car.park.ParkRequest request,
        io.grpc.stub.StreamObserver<org.car.park.ParkResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PARK_VEHICLE, responseObserver);
    }

    /**
     * <pre>
     * Streaming server
     * </pre>
     */
    public void parkVehicleManyTimes(org.car.park.ParkRequest request,
        io.grpc.stub.StreamObserver<org.car.park.ParkResponseManyTimes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PARK_VEHICLE_MANY_TIMES, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PARK_VEHICLE,
            asyncUnaryCall(
              new MethodHandlers<
                org.car.park.ParkRequest,
                org.car.park.ParkResponse>(
                  this, METHODID_PARK_VEHICLE)))
          .addMethod(
            METHOD_PARK_VEHICLE_MANY_TIMES,
            asyncServerStreamingCall(
              new MethodHandlers<
                org.car.park.ParkRequest,
                org.car.park.ParkResponseManyTimes>(
                  this, METHODID_PARK_VEHICLE_MANY_TIMES)))
          .build();
    }
  }

  /**
   */
  public static final class CarParkServiceStub extends io.grpc.stub.AbstractStub<CarParkServiceStub> {
    private CarParkServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarParkServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarParkServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarParkServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unery request 
     * </pre>
     */
    public void parkVehicle(org.car.park.ParkRequest request,
        io.grpc.stub.StreamObserver<org.car.park.ParkResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PARK_VEHICLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Streaming server
     * </pre>
     */
    public void parkVehicleManyTimes(org.car.park.ParkRequest request,
        io.grpc.stub.StreamObserver<org.car.park.ParkResponseManyTimes> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_PARK_VEHICLE_MANY_TIMES, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CarParkServiceBlockingStub extends io.grpc.stub.AbstractStub<CarParkServiceBlockingStub> {
    private CarParkServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarParkServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarParkServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarParkServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unery request 
     * </pre>
     */
    public org.car.park.ParkResponse parkVehicle(org.car.park.ParkRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PARK_VEHICLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Streaming server
     * </pre>
     */
    public java.util.Iterator<org.car.park.ParkResponseManyTimes> parkVehicleManyTimes(
        org.car.park.ParkRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_PARK_VEHICLE_MANY_TIMES, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CarParkServiceFutureStub extends io.grpc.stub.AbstractStub<CarParkServiceFutureStub> {
    private CarParkServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarParkServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarParkServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarParkServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unery request 
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.car.park.ParkResponse> parkVehicle(
        org.car.park.ParkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PARK_VEHICLE, getCallOptions()), request);
    }
  }

  private static final int METHODID_PARK_VEHICLE = 0;
  private static final int METHODID_PARK_VEHICLE_MANY_TIMES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CarParkServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CarParkServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PARK_VEHICLE:
          serviceImpl.parkVehicle((org.car.park.ParkRequest) request,
              (io.grpc.stub.StreamObserver<org.car.park.ParkResponse>) responseObserver);
          break;
        case METHODID_PARK_VEHICLE_MANY_TIMES:
          serviceImpl.parkVehicleManyTimes((org.car.park.ParkRequest) request,
              (io.grpc.stub.StreamObserver<org.car.park.ParkResponseManyTimes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CarParkServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.car.park.CarPark.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CarParkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarParkServiceDescriptorSupplier())
              .addMethod(METHOD_PARK_VEHICLE)
              .addMethod(METHOD_PARK_VEHICLE_MANY_TIMES)
              .build();
        }
      }
    }
    return result;
  }
}
