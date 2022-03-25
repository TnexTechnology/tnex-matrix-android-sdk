/*
 * Copyright (c) 2022 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.internal.auth.db.migration

import io.realm.DynamicRealm
import org.matrix.android.sdk.internal.auth.db.PendingSessionEntityFields
import org.matrix.android.sdk.internal.util.database.RealmMigrator
import timber.log.Timber

class MigrateAuthTo001(realm: DynamicRealm) : RealmMigrator(realm, 1) {

    override fun doMigrate(realm: DynamicRealm) {
        Timber.d("Create PendingSessionEntity")

        realm.schema.create("PendingSessionEntity")
                .addField(PendingSessionEntityFields.HOME_SERVER_CONNECTION_CONFIG_JSON, String::class.java)
                .setRequired(PendingSessionEntityFields.HOME_SERVER_CONNECTION_CONFIG_JSON, true)
                .addField(PendingSessionEntityFields.CLIENT_SECRET, String::class.java)
                .setRequired(PendingSessionEntityFields.CLIENT_SECRET, true)
                .addField(PendingSessionEntityFields.SEND_ATTEMPT, Integer::class.java)
                .setRequired(PendingSessionEntityFields.SEND_ATTEMPT, true)
                .addField(PendingSessionEntityFields.RESET_PASSWORD_DATA_JSON, String::class.java)
                .addField(PendingSessionEntityFields.CURRENT_SESSION, String::class.java)
                .addField(PendingSessionEntityFields.IS_REGISTRATION_STARTED, Boolean::class.java)
                .addField(PendingSessionEntityFields.CURRENT_THREE_PID_DATA_JSON, String::class.java)
    }
}
