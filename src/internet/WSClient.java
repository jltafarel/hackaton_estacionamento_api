package internet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import json.GsonParser;
import models.Estacionamento;
import models.Motorista;
import models.Retorno;
import models.Status;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import util.U;
import conf.Config;

public class WSClient {

	private static String auth;

	public final static Status criarPerfil(String user, String password, String nome) throws ServiceError {

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user", user));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("nome", nome));
		try {
			Result result = postWithParams(Config.getURLService() + "/cadastrar_motorista", params, false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Status status = GsonParser.newInstance().fromJson(result.content, Status.class);
				return status;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	public final static Status criarCarro(String descricao, String placa) throws ServiceError {

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("descricao", descricao));
		params.add(new BasicNameValuePair("placa", placa));
		try {
			Result result = postWithParams(Config.getURLService() + "/cadastrar_carro", params, false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Status status = GsonParser.newInstance().fromJson(result.content, Status.class);
				return status;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	public final static Status fazerLogin(String user, String password) throws ServiceError {

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user", user));
		params.add(new BasicNameValuePair("password", password));
		try {
			Result result = postWithParams(Config.getURLService() + "/fazer_login", params, false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Status status = GsonParser.newInstance().fromJson(result.content, Status.class);
				return status;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	public final static Status addCredito(Long idMotorista, Double valor) throws ServiceError {

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("id_motorista", String.valueOf(idMotorista)));
		params.add(new BasicNameValuePair("valor", String.valueOf(valor)));
		try {
			Result result = postWithParams(Config.getURLService() + "/add_credito", params, false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Status status = GsonParser.newInstance().fromJson(result.content, Status.class);
				return status;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	public final static Motorista infoMotorista(Long idMotorista) throws ServiceError {

		try {
			Result result = get(Config.getURLService() + "/info_motorista/" + String.valueOf(idMotorista), false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Motorista motorista = GsonParser.newInstance().fromJson(result.content, Motorista.class);
				return motorista;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	public final static Estacionamento checkin(Long idMotorista, Long idCarro) throws ServiceError {

		try {
			Result result = get(Config.getURLService() + "/checkin/" + String.valueOf(idMotorista) + "/" + String.valueOf(idCarro), false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Estacionamento estacionamento = GsonParser.newInstance().fromJson(result.content, Estacionamento.class);
				return estacionamento;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	public final static Estacionamento checkout(Long idEstacionamento) throws ServiceError {

		try {
			Result result = get(Config.getURLService() + "/checkout/" + String.valueOf(idEstacionamento), false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Estacionamento estacionamento = GsonParser.newInstance().fromJson(result.content, Estacionamento.class);
				return estacionamento;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	public final static Status consultaCarro(String placa) throws ServiceError {

		try {
			Result result = get(Config.getURLService() + "/consulta_carro/" + String.valueOf(placa), false);

			/* verifica se logou */
			result.validLogged();

			if (result.isOK()) {
				Status status = GsonParser.newInstance().fromJson(result.content, Status.class);
				return status;
			} else {
				Retorno retorno = Retorno.fromJSON(result.content);
				throw new ServiceError(result.code, retorno.getMensagem());
			}

		} catch (Throwable t) {
			throw new ServiceError(t);
		}
	}

	private static final Result get(String url, boolean usingBasicAuth) throws URISyntaxException, HttpException, IOException {

		Result result = new Result();
		HttpGet httpget = new HttpGet(url);

		HttpResponse response;
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, 3000);
		int timeoutSocket = 5000;
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

		DefaultHttpClient httpClientInstace = HttpClientSingleton.getHttpClientInstace();

		httpClientInstace.setParams(httpParameters);

		if (usingBasicAuth)
			applyAuth(httpget);

		response = httpClientInstace.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			result.code = String.valueOf(response.getStatusLine().getStatusCode());
			InputStream instream = entity.getContent();
			result.content = toString(instream);
			instream.close();
			System.out.println("get / Result from post JsonPost : " + result.code + " : " + result.content);
		}

		return result;
	}

	private final static Result post(String url, String json, boolean usingBasicAuth) throws URISyntaxException, HttpException, IOException {

		Result result = new Result();

		HttpPost httpPost = new HttpPost(new URI(url));
		httpPost.setHeader("Content-type", "application/json");
		if (!json.equals("")) {
			StringEntity sEntity = new StringEntity(json, "UTF-8");
			httpPost.setEntity(sEntity);
		}

		HttpResponse response;

		DefaultHttpClient httpClientInstace = HttpClientSingleton.getHttpClientInstace();

		if (usingBasicAuth)
			applyAuth(httpPost);

		response = httpClientInstace.execute(httpPost);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			result.code = String.valueOf(response.getStatusLine().getStatusCode());
			InputStream instream = entity.getContent();
			result.content = toString(instream);
			instream.close();
			System.out.println("post / Result from post JsonPost : " + result.code + " : " + result.content);
		}

		return result;
	}

	private final static Result postWithParams(String url, List<NameValuePair> params, boolean usingBasicAuth) throws URISyntaxException, HttpException, IOException {

		Result result = new Result();

		HttpPost httpPost = new HttpPost(new URI(url));
		httpPost.setEntity(new UrlEncodedFormEntity(params));

		HttpResponse response;

		DefaultHttpClient httpClientInstace = HttpClientSingleton.getHttpClientInstace();

		if (usingBasicAuth)
			applyAuth(httpPost);

		response = httpClientInstace.execute(httpPost);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			result.code = String.valueOf(response.getStatusLine().getStatusCode());
			InputStream instream = entity.getContent();
			result.content = toString(instream);
			instream.close();
			System.out.println("post / Result from post JsonPost : " + result.code + " : " + result.content);
		}

		return result;
	}

	private static String toString(InputStream is) throws IOException {

		byte[] bytes = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int lidos;
		while ((lidos = is.read(bytes)) > 0) {
			baos.write(bytes, 0, lidos);
		}
		return new String(baos.toByteArray());
	}

	private static class Result {
		public String code;
		public String content;

		public boolean isOK() {
			return "200".equals(code);
		}

		public boolean isInvalidLoginOrPassword() {
			if ("401".equals(code))
				return true;
			return U.coalesce(content, "").contains("id=\"j_password\"");
		}

		/**
		 * Lança uma exception caso login ou senha inválido
		 * 
		 * @throws ServiceError
		 */
		public void validLogged() throws ServiceError {
			if (isInvalidLoginOrPassword())
				throw new ServiceError(code, "Login ou senha inválido");
		}
	}

	private static void applyAuth(HttpPost post) throws UnsupportedEncodingException {
		post.setHeader("Authorization", auth);
	}

	private static void applyAuth(HttpGet get) throws UnsupportedEncodingException {
		get.setHeader("Authorization", auth);
	}
}
