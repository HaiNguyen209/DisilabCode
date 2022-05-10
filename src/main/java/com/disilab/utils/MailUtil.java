package com.disilab.utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    public static ResourceBundle bundle = ResourceBundle.getBundle("email");

    public static void send(String to, String sub,
                            String msg, final String user, final String pass) {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.allow8bitmime", "true");
        props.put("mail.smtps.allow8bitmime", "true");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub, "utf-8");
            message.setContent(msg, "text/html; charset=UTF-8");
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void setContent(String username, String link, String email) {
        String subject = "[Disilab] Xác minh tài khoản.";
        String message = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "\n" +
                "<head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "  <title></title>\n" +
                "  <style type=\"text/css\">\n" +
                "    @media only screen and (min-width: 620px) {\n" +
                "      .u-row {\n" +
                "        width: 600px !important;\n" +
                "      }\n" +
                "      .u-row .u-col {\n" +
                "        vertical-align: top;\n" +
                "      }\n" +
                "      .u-row .u-col-100 {\n" +
                "        width: 600px !important;\n" +
                "      }\n" +
                "    }\n" +
                "    \n" +
                "    @media (max-width: 620px) {\n" +
                "      .u-row-container {\n" +
                "        max-width: 100% !important;\n" +
                "        padding-left: 0px !important;\n" +
                "        padding-right: 0px !important;\n" +
                "      }\n" +
                "      .u-row .u-col {\n" +
                "        min-width: 320px !important;\n" +
                "        max-width: 100% !important;\n" +
                "        display: block !important;\n" +
                "      }\n" +
                "      .u-row {\n" +
                "        width: calc(100% - 40px) !important;\n" +
                "      }\n" +
                "      .u-col {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      .u-col>div {\n" +
                "        margin: 0 auto;\n" +
                "      }\n" +
                "    }\n" +
                "    \n" +
                "    body {\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "    }\n" +
                "    \n" +
                "    table,\n" +
                "    tr,\n" +
                "    td {\n" +
                "      vertical-align: top;\n" +
                "      border-collapse: collapse;\n" +
                "    }\n" +
                "    \n" +
                "    p {\n" +
                "      margin: 0;\n" +
                "    }\n" +
                "    \n" +
                "    .ie-container table,\n" +
                "    .mso-container table {\n" +
                "      table-layout: fixed;\n" +
                "    }\n" +
                "    \n" +
                "    * {\n" +
                "      line-height: inherit;\n" +
                "    }\n" +
                "    \n" +
                "    a[x-apple-data-detectors='true'] {\n" +
                "      color: inherit !important;\n" +
                "      text-decoration: none !important;\n" +
                "    }\n" +
                "    \n" +
                "    table,\n" +
                "    td {\n" +
                "      color: #000000;\n" +
                "    }\n" +
                "    \n" +
                "    a {\n" +
                "      color: #0000ee;\n" +
                "      text-decoration: underline;\n" +
                "    }\n" +
                "  </style>\n" +
                "\n" +
                "  <link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9;color: #000000\">\n" +
                "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "    <tbody>\n" +
                "      <tr style=\"vertical-align: top\">\n" +
                "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "              <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"width: 100% !important;\">\n" +
                "                    <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "                              <div style=\"color: #afb0c7; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-size: 14px; line-height: 23.8px;\">Disilab.com</span></p>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "              <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"width: 100% !important;\">\n" +
                "                    <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:20px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "                              <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                                <tr>\n" +
                "                                  <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "                                    <img align=\"center\" border=\"0\" src=\"https://images.unlayer.com/projects/77593/1651420658968-logo-black.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 32%;max-width: 179.2px;\"\n" +
                "                                      width=\"179.2\" />\n" +
                "                                  </td>\n" +
                "                                </tr>\n" +
                "                              </table>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #003399;\">\n" +
                "              <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"width: 100% !important;\">\n" +
                "                    <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "                              <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                                <tr>\n" +
                "                                  <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "                                    <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1597218650916-xxxxc.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 26%;max-width: 150.8px;\"\n" +
                "                                      width=\"150.8\" />\n" +
                "                                  </td>\n" +
                "                                </tr>\n" +
                "                              </table>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 31px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "                              <div style=\"color: #e5eaf5; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 28px; line-height: 39.2px;\"><strong><span style=\"line-height: 39.2px; font-size: 28px;\">X&aacute;c minh t&agrave;i khoản </span></strong>\n" +
                "                                  </span>\n" +
                "                                </p>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                "              <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"width: 100% !important;\">\n" +
                "                    <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:33px 55px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "                              <div style=\"line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 22px; line-height: 35.2px;\">Xin ch&agrave;o " + username + ", </span></p>\n" +
                "                                <p style=\"line-height: 160%; font-size: 14px;\"><span style=\"font-size: 18px; line-height: 28.8px;\">Cảm ơn bạn đ&atilde; tham gia Disilab</span></p>\n" +
                "                                <p style=\"line-height: 160%; font-size: 14px;\"><span style=\"font-size: 18px; line-height: 28.8px;\">Để ho&agrave;n th&agrave;nh đăng k&yacute; t&agrave;i khoản : h&atilde;y x&aacute;c minh địa chỉ email của bạn để giữ an to&agrave;n cho t&agrave;i khoản của bạn v&agrave; mang lại trải nghiệm tốt nhất tại disilab !</span></p>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                              <div align=\"center\">\n" +
                "                                <a href=\"" + link + "\" target=\"_blank\" style=\"box-sizing: border-box;display: inline-block;font-family:'Cabin',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #ff6600; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;\">\n" +
                "                                  <span style=\"display:block;padding:14px 44px 13px;line-height:120%;\"><span style=\"font-size: 16px; line-height: 19.2px;\"><strong><span style=\"line-height: 19.2px; font-size: 16px;\">X&aacute;c minh email</span></strong>\n" +
                "                                  </span>\n" +
                "                                  </span>\n" +
                "                                </a>\n" +
                "                              </div>\n" +
                "\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #e5eaf5;\">\n" +
                "              <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"width: 100% !important;\">\n" +
                "                    <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:41px 55px 18px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "                              <div style=\"color: #003399; line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 20px; line-height: 32px;\"><strong>Th&ocirc;ng tin hỗ trợ</strong></span></p>\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 16px; line-height: 25.6px; color: #000000;\">+84 888195313</span></p>\n" +
                "                                <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 16px; line-height: 25.6px; color: #000000;\">Info@disilab.com</span></p>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 33px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "                              <div align=\"center\">\n" +
                "                                <div style=\"display: table; max-width:97px;\">\n" +
                "                                  <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 17px\">\n" +
                "                                    <tbody>\n" +
                "                                      <tr style=\"vertical-align: top\">\n" +
                "                                        <td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "                                          <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
                "                                            <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded/facebook.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "                                          </a>\n" +
                "                                        </td>\n" +
                "                                      </tr>\n" +
                "                                    </tbody>\n" +
                "                                  </table>\n" +
                "                                  <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
                "                                    <tbody>\n" +
                "                                      <tr style=\"vertical-align: top\">\n" +
                "                                        <td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "                                          <a href=\"https://email.com/\" title=\"Email\" target=\"_blank\">\n" +
                "                                            <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded/email.png\" alt=\"Email\" title=\"Email\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "                                          </a>\n" +
                "                                        </td>\n" +
                "                                      </tr>\n" +
                "                                    </tbody>\n" +
                "                                  </table>\n" +
                "                                </div>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "          <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "            <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #003399;\">\n" +
                "              <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
                "                <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #003399;\"><![endif]-->\n" +
                "\n" +
                "                <!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                "                <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                "                  <div style=\"width: 100% !important;\">\n" +
                "                    <!--[if (!mso)&(!IE)]><!-->\n" +
                "                    <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\">\n" +
                "                      <!--<![endif]-->\n" +
                "\n" +
                "                      <table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\" align=\"left\">\n" +
                "\n" +
                "                              <div style=\"color: #fafafa; line-height: 180%; text-align: center; word-wrap: break-word;\">\n" +
                "                                <p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-size: 16px; line-height: 28.8px;\">Copyrights &copy;Disilab All Rights Reserved</span></p>\n" +
                "                              </div>\n" +
                "\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        MailUtil.send(email, subject, message, bundle.getString("email"), bundle.getString("pass"));
    }

}
