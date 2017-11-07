/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.it.br.gameserver.handler.chathandlers;

import com.it.br.gameserver.handler.IChatHandler;
import com.it.br.gameserver.model.actor.instance.L2PcInstance;
import com.it.br.gameserver.network.serverpackets.CreatureSay;

public class ChatClan implements IChatHandler
{
	private static final int[] COMMAND_IDS = { 4 };

	/**
	 * Handle chat type 'clan'
	 *
	 * @see com.it.br.gameserver.handler.IChatHandler#handleChat(int, com.it.br.gameserver.model.actor.instance.L2PcInstance, java.lang.String)
	 */

	public void handleChat(int type, L2PcInstance activeChar, String target, String text)
	{
		if (activeChar.getClan() != null)
		{
			CreatureSay cs = new CreatureSay(activeChar.getObjectId(), type, activeChar.getName(), text);
			activeChar.getClan().broadcastToOnlineMembers(cs);
		}
	}

	/**
	 * Returns the chat types registered to this handler
	 *
	 * @see com.it.br.gameserver.handler.IChatHandler#getChatTypeList()
	 */

	public int[] getChatTypeList()
	{
		return COMMAND_IDS;
	}
}