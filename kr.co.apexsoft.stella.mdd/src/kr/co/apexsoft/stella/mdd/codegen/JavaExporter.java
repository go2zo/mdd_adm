package kr.co.apexsoft.stella.mdd.codegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kr.co.apexsoft.stella.cmm.CMMElement;
import kr.co.apexsoft.stella.mdd.Activator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class JavaExporter implements Exporter {

	@Override
	public void export(CMMElement element) {
		List<CMMElement> elements = new ArrayList<>();
		elements.add(element);
		export(elements);
	}

	@Override
	public void export(List<? extends CMMElement> elements) {
		for (CMMElement element : elements) {
			try {
				InputStream inputStream = getClass().getResourceAsStream("velocity.properties");
				Properties properties = new Properties();
				properties.load(inputStream);

				Velocity.init(properties);
				
				VelocityContext context = new VelocityContext();
				context.put("element", element);

				Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
				URL url = FileLocator.find(bundle, new Path("templates/template.vm"), null);
				File f = new File(FileLocator.resolve(url).toURI());

				Template template = Velocity.getTemplate(f.getCanonicalPath());
				BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(System.out));
				template.merge(context, fout);
				fout.flush();
//				fout.close();
			} catch (ResourceNotFoundException rnfe) {
			} catch (ParseErrorException pee) {
			} catch (MethodInvocationException mie) {
			} catch (IOException e) {
			} catch (URISyntaxException e) {
			}

		}
	}

}
