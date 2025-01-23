package learning.grpc.server;

import io.grpc.stub.StreamObserver;
import org.car.park.CarParkServiceGrpc;
import org.car.park.ParkRequest;
import org.car.park.ParkResponse;
import org.car.park.ParkResponseManyTimes;

public class CarparkServiceImpl extends CarParkServiceGrpc.CarParkServiceImplBase {

  @Override
  public void parkVehicle(ParkRequest request, StreamObserver<ParkResponse> responseObserver) {
    String vehicleNo = request.getVehicle().getVehicleNumber();
    String vehicleType = request.getVehicle().getVehicleType();

    String resultMsg ="The vehicle of number " + vehicleNo + " and type " + vehicleType + " is parked.";
    System.out.println(resultMsg);

    ParkResponse parkResponse = ParkResponse.newBuilder()
        .setResult(resultMsg)
        .build();

    responseObserver.onNext(parkResponse);
    responseObserver.onCompleted();
  }

  @Override
  public void parkVehicleManyTimes(ParkRequest request, StreamObserver<ParkResponseManyTimes> responseObserver) {
    String vehicleNo = request.getVehicle().getVehicleNumber();
    String vehicleType = request.getVehicle().getVehicleType();

    String response1 = "The vehicle of number " + vehicleNo + " and type " + vehicleType + " entered the park.";
    ParkResponseManyTimes parkResponse1 = ParkResponseManyTimes
        .newBuilder()
        .setResult(response1)
        .build();
    responseObserver.onNext(parkResponse1);

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Build and send the second response.
    String response2 = "The ground floor is full.";
    ParkResponseManyTimes parkResponse2 = ParkResponseManyTimes
        .newBuilder()
        .setResult(response2)
        .build();
    responseObserver.onNext(parkResponse2);

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Build and send the third response.
    String response3 = "The vehicle of number " + vehicleNo + " and type " + vehicleType + " is parked in the first floor";
    ParkResponseManyTimes parkResponse3 = ParkResponseManyTimes
        .newBuilder()
        .setResult(response3)
        .build();
    responseObserver.onNext(parkResponse3);

    // Complete the communication.
    responseObserver.onCompleted();
  }
}
