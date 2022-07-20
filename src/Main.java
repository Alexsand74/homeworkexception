public class Main {
    public static void main(String[] args) {

        System.out.println("Код лежит здесь !");
        boolean test1 = verificationAuthorization("login_45", "qwertyu_2345", "qwertyu_2345");
        System.out.println(test1);
        boolean test2 = verificationAuthorization("login_45", "qwertyu_2345", "qwertyu_2346");
        System.out.println(test2);
    }

    private static boolean verificationAuthorization(String login, String password, String confirmPassword) {
        try {
            examinationLogin(login);
            examinationPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return false;
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void examinationLogin(String login) throws WrongLoginException {
        if (login.isEmpty() || login.length() > 20) {
            throw new WrongLoginException("Длина логина больше, чем требуется !");
        }
        if (!comparisonСharacterSet(login)) {
            throw new WrongLoginException("Недопустимый символ в логине !");
        }
    }

    private static void examinationPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.isEmpty() || password.length() >= 20) {
            throw new WrongPasswordException("Длинна пароля больше, чем требуется !");
        }
        if (!comparisonСharacterSet(password)) {
            throw new WrongPasswordException("Недопустимый символ в password");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль  не  подходит !");
        }

    }

    private static boolean comparisonСharacterSet(String string) {
        for (char c : string.toCharArray()) {
            if ((c >= 'a' && c <= 'z')
                 || (c >= 'A' && c <= 'Z')
                     || (c >= '0') && (c <= '9')
                         || c == '_') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
