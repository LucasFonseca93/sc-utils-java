package br.com.softctrl.utils.net;

import java.io.Serializable;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

import br.com.softctrl.utils.Base64;

/*
The MIT License (MIT)
Copyright (c) 2016 Carlos Timoshenko Rodrigues Lopes
http://www.0x09.com.br
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

/**
 * 
 * @author carlostimoshenkorodrigueslopes@gmail.com
 */
public class SCAuthenticator extends Authenticator implements Serializable {
    private static final long serialVersionUID = -6629397661312630599L;
    private String username;
    private String password;

    /**
     * 
     * @param username
     * @param password
     */
    public SCAuthenticator(String username, String password) {
      this.username = username;
      this.password = password;
    }

    /**
     * 
     * @param value
     * @return
     */
    private static final String get(final String value) {
      String result = value;
      if (value != null && value.length() > 0)
        result = new String(Base64.decode(value, Base64.DEFAULT));
      System.out.println(result);
      return result;
    }

    /*
     * (non-Javadoc)
     * @see java.net.Authenticator#getPasswordAuthentication()
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(get(username), (get(password) + "").toCharArray());
    }

  }
