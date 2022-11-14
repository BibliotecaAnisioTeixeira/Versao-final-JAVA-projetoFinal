/** Classe para autencicação do email
 * @author Allan da Silva Fernandes
 * @version 1.0
 * @since 22/09/2022
 */
package classes;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/** Método de autencicação
 */
public class SmtpAuthenticator extends Authenticator {
public SmtpAuthenticator() {

    super();
}

@Override

/** Método de autencicação da senha
 */
public PasswordAuthentication getPasswordAuthentication() {
 String username = "projetolivraria1305@gmail.com";
 String password = "enbtipdftamteivq";
    if ((username != null) && (username.length() > 0) && (password != null) 
      && (password.length   () > 0)) {

        return new PasswordAuthentication(username, password);
    }

    return null;
}
}