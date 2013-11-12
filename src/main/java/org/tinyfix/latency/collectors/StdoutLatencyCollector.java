package org.tinyfix.latency.collectors;

public class StdoutLatencyCollector implements LatencyCollector {

    private StringBuilder sb = new StringBuilder(128);

    @Override
    public void recordLatency(byte[] buffer, int offset, int length, long latency) {
        sb.setLength(0);
        sb.append("Token ");
        for (int i = 0; i < length; i++) {
            sb.append(buffer[offset++]);
        }
        sb.append(": ");

        sb.append(latency);
        sb.append('\n');
        System.out.print (sb.toString());
    }

    @Override
    public void missingInboundSignal(byte[] buffer, int offset, int length) {
        System.err.println("Can't locate inbound signal " + new String (buffer, offset, length));
    }

    @Override
    public void close() {
    }

}
