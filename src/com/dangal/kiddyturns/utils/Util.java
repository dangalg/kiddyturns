package com.dangal.kiddyturns.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Util {
	
	public Context context;
	Builder dlgAlert;

	public Util(Context pcontext) {
		context = pcontext;
		dlgAlert = new AlertDialog.Builder(context);
	}
	
	public void MakeShortToast(String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	public void MakeLongToast(String message) {
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
	
	public void EmailMsgbx(String title, String message, final String email) {

		dlgAlert.setTitle(title);
		dlgAlert.setMessage(message);
		dlgAlert.setPositiveButton("×©×?×— ×?×™×™×? ×?×‘×§×©×ª ×¡×™×¡×?×?", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				EmailAdmin();
//				((Activity) context).finish();
			}
		});
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}
	
	public void EmailAdmin()
	{
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri
				.fromParts("mailto", Constants.ADMINEMAIL, null));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT,
				"×¡×™×¡×?×? ×?×?×¤×?×™×§×¦×™×™×ª ×”×?×ª×¨");
		emailIntent.putExtra(Intent.EXTRA_TEXT,
						"×?× ×? ×©×?×—×™ ×?×?×™ ×?×ª ×”×¡×™×¡×?×? ×?×?×ª×¨, ×©×?×™ ×”×•×?: ");
		context.startActivity(Intent.createChooser(emailIntent,
				"×©×?×— ×?×™×™×?..."));
	}
}
