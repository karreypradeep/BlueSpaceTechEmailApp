package com.bluespacetech.notifications.email.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.bluespacetech.core.utility.CryptoUtil;
import com.bluespacetech.notifications.email.valueobjects.EmailContactGroupVO;

public class EmailUtils {

	public final static String EMAIL_SECRET_KEY = "ThisIsKeyForEmailEncryptDecrypt";

	public static String generateUnscribeLink(final EmailContactGroupVO emailContactGroupVO,
			final String emailRequestURL) {
		final StringBuffer unscribeLink = new StringBuffer(emailRequestURL + "/unsubscribe");
		try {
			final CryptoUtil cryptoUtil = new CryptoUtil();
			try {
				unscribeLink.append("?contactEmail=").append(emailContactGroupVO.getContactEmail())
				.append("&contactId=")
				.append(cryptoUtil.encrypt(EMAIL_SECRET_KEY, emailContactGroupVO.getContactId().toString()))
				.append("&groupId=")
				.append(cryptoUtil.encrypt(EMAIL_SECRET_KEY, emailContactGroupVO.getGroupId().toString()));
			} catch (InvalidKeyException | InvalidKeySpecException | NoSuchPaddingException
					| InvalidAlgorithmParameterException | UnsupportedEncodingException | IllegalBlockSizeException
					| BadPaddingException e) {
				e.printStackTrace();
			}
		} catch (final NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unscribeLink.toString();
	}

}
