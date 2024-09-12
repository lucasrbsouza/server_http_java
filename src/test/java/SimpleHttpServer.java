import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server= new ServerSocket(8000);
        System.out.println("Escutando conexão na porta 8000");

        while (true){
            try (Socket client = server.accept()) {
                InputStreamReader isr = new InputStreamReader(client.getInputStream());
                BufferedReader bfr = new BufferedReader(isr);
                String line = bfr.readLine();
                String string = "<!DOCTYPE html>\n" +
                        "<html lang=\"pt-BR\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>Servidor Java HTTP</title>\n" +
                        "</head>\n" +
                        "<body style=\"margin: 0; font-family: 'Helvetica Neue', Arial, sans-serif; background-color: #f4f4f9; color: #333;\">\n" +
                        "\n" +
                        "    <!-- Cabeçalho -->\n" +
                        "    <header style=\"background-color: #000; color: #fff; padding: 20px; text-align: center;\">\n" +
                        "        <h1 style=\"margin: 0; font-size: 2.5em;\">Meu Servidor HTTP</h1>\n" +
                        "    </header>\n" +
                        "\n" +
                        "    <!-- Conteúdo Principal -->\n" +
                        "    <main style=\"padding: 40px; max-width: 800px; margin: 0 auto; text-align: center;\">\n" +
                        "        <h2 style=\"font-size: 2em; color: #333;\">Olá a todos!</h2>\n" +
                        "        <p style=\"font-size: 1.2em; color: #555; line-height: 1.6;\">\n" +
                        "            Bem-vindo a pagina do meu servidor em java estilizado de forma simples. \n" +
                        "            Este layout é limpo e direto, com um design responsivo que se adapta bem a diferentes tamanhos de tela.\n" +
                        "        </p>\n" +
                        "    </main>\n" +
                        "\n" +
                        "    <!-- Rodapé -->\n" +
                        "    <footer style=\"background-color: #000; color: #fff; text-align: center; padding: 15px; position: fixed; bottom: 0; width: 100%;\">\n" +
                        "        <p style=\"margin: 0;\">© 2024 Meu Site Simples. Todos os direitos reservados.</p>\n" +
                        "        <p style=\"margin: 0; padding: 10;\">Feito por Lucas Souza.</p>\n" +
                        "    </footer>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>\n";

                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + string;
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
