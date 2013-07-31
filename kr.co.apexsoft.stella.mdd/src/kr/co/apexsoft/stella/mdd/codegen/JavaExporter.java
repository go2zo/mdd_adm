package kr.co.apexsoft.stella.mdd.codegen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kr.co.apexsoft.stella.cmm.CMMElement;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class JavaExporter implements Exporter {

	@Override
	public void export(CMMElement element) {
		List<CMMElement> elements = new ArrayList<>();
		elements.add(element);
		export(elements);
	}

	@Override
	public void export(List<CMMElement> elements) {
		for (CMMElement element : elements) {
			try {
				InputStream inputStream = getClass().getResourceAsStream("velocity.properties");
				Properties properties = new Properties();
				properties.load(inputStream);

				Velocity.init(properties);
//				Velocity.init("velocity.properties");
				
				VelocityContext context = new VelocityContext();
				context.put("class", element);

				Template template = Velocity.getTemplate("templates/Template.vm");
				BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(System.out));
				template.merge(context, fout);
				fout.flush();
				fout.close();
				
			} catch (ResourceNotFoundException rnfe) {
			} catch (ParseErrorException pee) {
			} catch (MethodInvocationException mie) {
			} catch (IOException e) {
			}

		}
	}

}
