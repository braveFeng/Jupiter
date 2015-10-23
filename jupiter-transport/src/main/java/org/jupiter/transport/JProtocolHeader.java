package org.jupiter.transport;

/**
 * jupiter传输层协议头格式:
 *
 * 消息头16个字节定长
 * = 2 // MAGIC = (short) 0xbabe
 * + 1 // 消息标志位, 用来表示消息类型Request/Response/Heartbeat等
 * + 1 // 状态位, 设置请求响应状态
 * + 8 // 消息 id long 类型
 * + 4 // 消息体body长度, int类型
 *
 * jupiter
 * org.jupiter.transport.api
 *
 * @author jiachun.fjc
 */
public class JProtocolHeader {

    /** 协议头长度 */
    public static final int HEAD_LENGTH = 16;
    /** Magic */
    public static final short MAGIC = (short) 0xbabe;

    /** ============================================= For RPC ======================================================= */

    /** Request */
    public static final byte REQUEST = 1;
    /** Response */
    public static final byte RESPONSE = 2;

    /** ============================================================================================================= */

    /** ============================================= For Registry ================================================== */

    /** 发布服务 */
    public static final byte PUBLISH_SERVICE = 65;
    /** 取消发布服务 */
    public static final byte UN_PUBLISH_SERVICE = 66;
    /** 订阅服务 */
    public static final byte SUBSCRIBE_SERVICE = 67;

    /** ============================================================================================================= */

    /** Acknowledge */
    public static final byte ACK = 126;
    /** Heartbeat */
    public static final byte HEARTBEAT = 127;

    private byte sign;
    private byte status;
    private long id;
    private int bodyLength;

    public byte sign() {
        return sign;
    }

    public void sign(byte sign) {
        this.sign = sign;
    }

    public byte status() {
        return status;
    }

    public void status(byte status) {
        this.status = status;
    }

    public long id() {
        return id;
    }

    public void id(long id) {
        this.id = id;
    }

    public int bodyLength() {
        return bodyLength;
    }

    public void bodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }

    @Override
    public String toString() {
        return "JProtocolHeader{" +
                "sign=" + sign +
                ", status=" + status +
                ", id=" + id +
                ", bodyLength=" + bodyLength +
                '}';
    }
}
