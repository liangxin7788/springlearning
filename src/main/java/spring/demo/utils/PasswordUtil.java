//package spring.demo.utils;
//
///**
// * @Package: spring.demo.utils
// * @ClassName: PasswordUtil
// * @Description: java类作用描述
// * @Author: liangxin
// * @CreateDate: 2019/11/11 10:49
// * @UpdateDate: 2019/11/11 10:49
// */
//public class PasswordUtil {
//
//    public static final String HASH_ALGORITHM = "SHA-1";
//    public static final int HASH_INTERATIONS = 1024;
//    public static final int SALT_SIZE = 8;
//
//    /**
//     * @param plainPassword
//     * @return password 加密密码(生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash)
//     */
//    public static String entryptPassword(String plainPassword) {
//        byte[] salt = Digests.generateSalt(SALT_SIZE);
//        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
//        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
//    }
//
//    /**
//     * @param plainPassword
//     * @param password
//     * @return boolean 解密判断密码是否正确
//     */
//    public static boolean validatePassword(String plainPassword, String password) {
//        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
//        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
//        return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
//    }
//
//}
