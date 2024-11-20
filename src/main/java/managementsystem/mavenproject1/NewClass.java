
package managementsystem.mavenproject1;

import javax.bluetooth.*;
public class NewClass {


    public static void main(String[] args) throws BluetoothStateException {
        LocalDevice localDevice = LocalDevice.getLocalDevice();
        DiscoveryAgent agent = localDevice.getDiscoveryAgent();

        agent.startInquiry(DiscoveryAgent.GIAC, new DiscoveryListener() {
            @Override
            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                try {
                    System.out.println("Device found: " + btDevice.getFriendlyName(false));
                } catch (Exception e) {
                    System.out.println("Device found: " + btDevice.getBluetoothAddress());
                }
            }

            @Override
            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                System.out.println("Service discovered");
            }

            @Override
            public void serviceSearchCompleted(int transID, int respCode) {
                System.out.println("Service search completed");
            }

            @Override
            public void inquiryCompleted(int discType) {
                System.out.println("Device inquiry completed");
            }
        });
    }
}
